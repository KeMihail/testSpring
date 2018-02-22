package by.itacademy.keikom.taxi.dao.dbmodel;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ extends by.itacademy.keikom.taxi.dao.dbmodel.AbstractModel_ {

	public static volatile SingularAttribute<Order, Integer> inactivityMinutes;
	public static volatile SingularAttribute<Order, Boolean> deleted;
	public static volatile SingularAttribute<Order, Double> summ;
	public static volatile SingularAttribute<Order, Rate> rate;
	public static volatile SingularAttribute<Order, Car> car;
	public static volatile SingularAttribute<Order, String> departureAddress;
	public static volatile SingularAttribute<Order, Double> distanceOrder;
	public static volatile SingularAttribute<Order, Double> distancePaid;
	public static volatile SingularAttribute<Order, String> arrivalAddress;
	public static volatile SingularAttribute<Order, Timestamp> orderEnd;
	public static volatile SingularAttribute<Order, Timestamp> orderBegin;
	public static volatile SingularAttribute<Order, User> user;

}

