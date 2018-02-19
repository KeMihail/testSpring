package by.itacademy.keikom.taxi.dao.dbmodel;

import by.itacademy.keikom.taxi.dao.enums.CarStatus;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Car.class)
public abstract class Car_ {

	public static volatile SingularAttribute<Car, Timestamp> created;
	public static volatile SingularAttribute<Car, Timestamp> modified;
	public static volatile SingularAttribute<Car, Model> model;
	public static volatile ListAttribute<Car, Order> orders;
	public static volatile SingularAttribute<Car, Integer> id;
	public static volatile SingularAttribute<Car, User> user;
	public static volatile SingularAttribute<Car, Integer> releaseYear;
	public static volatile SingularAttribute<Car, LegalEntity> legalEntity;
	public static volatile SingularAttribute<Car, CarStatus> status;

}

