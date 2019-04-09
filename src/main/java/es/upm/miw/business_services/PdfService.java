package es.upm.miw.business_services;

import es.upm.miw.documents.Shopping;
import es.upm.miw.documents.ShoppingState;
import es.upm.miw.documents.Ticket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;

@Service
public class PdfService {

    private static final String[] TABLE_COLUMNS_HEADERS = {" ", "Desc.", "Ud.", "Dto.%", "€", "E."};
    private static final float[] TABLE_COLUMNS_SIZES_TICKETS = {15, 90, 15, 25, 35, 15};

    @Value("${miw.company.logo}")
    private String logo;

    @Value("${miw.company.name}")
    private String name;

    @Value("${miw.company.nif}")
    private String nif;

    @Value("${miw.company.phone}")
    private String phone;

    @Value("${miw.company.address}")
    private String address;

    @Value("${miw.company.email}")
    private String email;

    @Value("${miw.company.web}")
    private String web;

    public byte[] generateTicket(Ticket ticket) {
        final String path = "/tpv-pdfs/tickets/ticket-" + ticket.getId();
        PdfBuilder pdf = new PdfBuilder(path);
        pdf.image(this.logo).paragraphEmphasized(this.name).paragraphEmphasized("Tfn: " + this.phone)
                .paragraph("NIF: " + this.nif + "   -   " + this.address)
                .paragraph("Email: " + this.email + "  -  " + "Web: " + this.web);
        pdf.line();
        if (ticket.isDebt()) {
            pdf.paragraphEmphasized("RESERVA");
            pdf.paragraphEmphasized("Abonado: " + ticket.pay().setScale(2, RoundingMode.HALF_UP) + "€");
            pdf.paragraphEmphasized("Pendiente: " + ticket.debt().setScale(2, RoundingMode.HALF_UP) + "€");
        } else {
            pdf.paragraphEmphasized("TICKET");
        }
        pdf.barCode(ticket.getId());
        pdf.line();
        pdf.paragraphEmphasized(ticket.getCreationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        int notCommitted = 0;
        PdfTableBuilder table = pdf.table(TABLE_COLUMNS_SIZES_TICKETS).tableColumnsHeader(TABLE_COLUMNS_HEADERS);
        for (int i = 0; i < ticket.getShoppingList().length; i++) {
            Shopping shopping = ticket.getShoppingList()[i];
            String state = "";
            if (shopping.getShoppingState() != ShoppingState.COMMITTED && shopping.getAmount() > 0) {
                state = "N";
                notCommitted++;
            }
            String discount = "";
            if ((shopping.getDiscount().doubleValue() > 0.009) && !shopping.getArticle().getCode().equals("1")) {
                discount = "" + shopping.getDiscount().setScale(2, RoundingMode.HALF_UP);
            }
            table.tableCell(String.valueOf(i + 1), shopping.getDescription(), "" + shopping.getAmount(), discount,
                    shopping.getShoppingTotal().setScale(2, RoundingMode.HALF_UP) + "€", state);
        }
        table.tableColspanRight(ticket.getTotal().setScale(2, RoundingMode.HALF_UP) + "€").build();
        pdf.paragraph(ticket.getNote());
        if (notCommitted > 0) {
            pdf.paragraphEmphasized("Artículos pendientes de entrega: " + notCommitted);
            if (ticket.getUser() != null) {
                pdf.paragraph("Teléfono de contacto: " + ticket.getUser().getMobile() + " - " + ticket.getUser().getUsername().substring(0,
                        (ticket.getUser().getUsername().length() > 10) ? 10 : ticket.getUser().getUsername().length()));
            }
            pdf.qrCode(ticket.getReference());
        }
        pdf.line().paragraph("Periodo de devolución o cambio: 15 dias a partir de la fecha del ticket");
        pdf.paragraphEmphasized("Gracias por su visita").paragraphEmphasized(" ").line();
        return pdf.build();
    }
}
