package by.itacademy.keikom.taxi.dao.dbmodel;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Costs.class)
public abstract class Costs_ {

	public static volatile SingularAttribute<Costs, Double> insurance;
	public static volatile SingularAttribute<Costs, Double> other;
	public static volatile SingularAttribute<Costs, Double> carService;
	public static volatile SingularAttribute<Costs, Timestamp> created;
	public static volatile SingularAttribute<Costs, Double> taxes;
	public static volatile SingularAttribute<Costs, Double> technicalInspection;
	public static volatile SingularAttribute<Costs, Timestamp> modified;
	public static volatile SingularAttribute<Costs, Double> salaryDriver;
	public static volatile SingularAttribute<Costs, Double> pretripInspection;
	public static volatile SingularAttribute<Costs, Double> fuelConsumption;
	public static volatile SingularAttribute<Costs, Integer> carId;

}

