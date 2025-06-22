package co.edu.udea.nexum.profile.user.domain.model;

import co.edu.udea.nexum.profile.common.domain.model.Model;
import co.edu.udea.nexum.profile.common.domain.utils.annotations.Generated;
import co.edu.udea.nexum.profile.common.domain.utils.contracts.BaseBuilder;
import co.edu.udea.nexum.profile.user.domain.utils.enums.DocumentType;

@Generated
public class IdentityDocumentType implements Model<Long> {
    private Long id;
    private DocumentType documentType;

    public IdentityDocumentType(IdentityDocumentTypeBuilder builder) {
        this.id = builder.id;
        this.documentType = builder.documentType;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public static IdentityDocumentTypeBuilder builder() {
        return new IdentityDocumentTypeBuilder();
    }

    @Generated
    public static class IdentityDocumentTypeBuilder implements BaseBuilder<IdentityDocumentType> {
        private Long id;
        private DocumentType documentType;

        public IdentityDocumentTypeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public IdentityDocumentTypeBuilder documentType(DocumentType documentType) {
            this.documentType = documentType;
            return this;
        }

        @Override
        public IdentityDocumentType build() {
            return new IdentityDocumentType(this);
        }
    }
}
