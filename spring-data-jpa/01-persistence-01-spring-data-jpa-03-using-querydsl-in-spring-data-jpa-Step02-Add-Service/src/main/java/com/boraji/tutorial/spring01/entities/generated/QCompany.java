package com.boraji.tutorial.spring01.entities.generated;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;

import com.boraji.tutorial.spring01.entities.Company;
import com.boraji.tutorial.spring01.entities.CompanyType;
import com.boraji.tutorial.spring01.entities.Contact;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompany is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompany extends EntityPathBase<Company> {

    private static final long serialVersionUID = 1157339878L;

    public static final QCompany company = new QCompany("company");

    public final ListPath<Contact, QContact> contacts = this.<Contact, QContact>createList("contacts", Contact.class, QContact.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final EnumPath<CompanyType> type = createEnum("type", CompanyType.class);

    public QCompany(String variable) {
        super(Company.class, forVariable(variable));
    }

    public QCompany(Path<? extends Company> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompany(PathMetadata metadata) {
        super(Company.class, metadata);
    }

}

