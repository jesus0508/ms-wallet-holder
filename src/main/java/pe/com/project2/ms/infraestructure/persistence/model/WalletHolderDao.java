package pe.com.project2.ms.infraestructure.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.project2.ms.domain.DocumentType;
import pe.com.project2.ms.domain.WalletHolder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("walletHolder")
public class WalletHolderDao {
    @Id
    private String id;
    private String names;
    private String paternalSurname;
    private String maternalSurname;
    private String documentNumber;
    private DocumentType documentType;
    @Indexed(unique = true)
    private String phoneNumber;
    private String email;

    public WalletHolderDao(WalletHolder walletHolder) {
        id = walletHolder.getId();
        names = walletHolder.getNames();
        paternalSurname = walletHolder.getPaternalSurname();
        maternalSurname = walletHolder.getMaternalSurname();
        documentNumber = walletHolder.getDocumentNumber();
        documentType = walletHolder.getDocumentType();
        phoneNumber = walletHolder.getPhoneNumber();
        email = walletHolder.getEmail();
    }

    public WalletHolder toWalletHolder() {
        WalletHolder walletHolder = new WalletHolder();
        walletHolder.setId(id);
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
