package com.example.javapersistence.ch03.models;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Item.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Item_ {

	
	/**
	 * @see com.example.javapersistence.ch03.models.Item#auctionEnd
	 **/
	public static volatile SingularAttribute<Item, LocalDate> auctionEnd;
	
	/**
	 * @see com.example.javapersistence.ch03.models.Item#name
	 **/
	public static volatile SingularAttribute<Item, String> name;
	
	/**
	 * @see com.example.javapersistence.ch03.models.Item#id
	 **/
	public static volatile SingularAttribute<Item, Long> id;
	
	/**
	 * @see com.example.javapersistence.ch03.models.Item
	 **/
	public static volatile EntityType<Item> class_;

	public static final String AUCTION_END = "auctionEnd";
	public static final String NAME = "name";
	public static final String ID = "id";

}

