package com.spring01.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QContact is a Querydsl query type for Contact
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContact extends EntityPathBase<Contact> {

    private static final long serialVersionUID = -601913914L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QContact contact = new QContact("contact");

    public final QCompany company;

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final EnumPath<ContactType> type = createEnum("type", ContactType.class);

    public QContact(String variable) {
        this(Contact.class, forVariable(variable), INITS);
    }

    public QContact(Path<? extends Contact> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QContact(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QContact(PathMetadata metadata, PathInits inits) {
        this(Contact.class, metadata, inits);
    }

    public QContact(Class<? extends Contact> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company")) : null;
    }

}

