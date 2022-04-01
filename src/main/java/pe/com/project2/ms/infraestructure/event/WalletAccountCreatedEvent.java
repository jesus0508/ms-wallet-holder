package pe.com.project2.ms.infraestructure.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.project2.ms.domain.DocumentType;
import pe.com.project2.ms.domain.WalletHolder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletAccountCreatedEvent {
    private String names;
    private String paternalSurname;
    private String maternalSurname;
    private String documentNumber;
    private DocumentType documentType;
    private String phoneNumber;
    private String email;

    public WalletHolder toWalletHolder() {
        WalletHolder walletHolder = new WalletHolder();
        walletHolder.setNames(names);
        walletHolder.setPaternalSurname(paternalSurname);
        walletHolder.setMaternalSurname(maternalSurname);
        walletHolder.setDocumentNumber(documentNumber);
        walletHolder.setDocumentType(documentType);
        walletHolder.setPhoneNumber(phoneNumber);
        walletHolder.setEmail(email);
        return walletHolder;
    }
}
