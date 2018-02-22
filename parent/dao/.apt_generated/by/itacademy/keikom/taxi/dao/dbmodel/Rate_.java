package by.itacademy.keikom.taxi.dao.dbmodel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rate.class)
public abstract class Rate_ extends by.itacademy.keikom.taxi.dao.dbmodel.AbstractModel_ {

	public static volatile SingularAttribute<Rate, Double> priceKilometr;
	public static volatile SingularAttribute<Rate, Double> priceLanding;
	public static volatile SingularAttribute<Rate, String> name;
	public static volatile SingularAttribute<Rate, Double> priceMinuteWait;
	public static volatile ListAttribute<Rate, Order> orders;

}

