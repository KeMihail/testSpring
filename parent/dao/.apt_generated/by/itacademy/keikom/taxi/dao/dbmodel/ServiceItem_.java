package by.itacademy.keikom.taxi.dao.dbmodel;

import by.itacademy.keikom.taxi.dao.enums.EServiceItem;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ServiceItem.class)
public abstract class ServiceItem_ extends by.itacademy.keikom.taxi.dao.dbmodel.AbstractModel_ {

	public static volatile SingularAttribute<ServiceItem, EServiceItem> item;
	public static volatile SingularAttribute<ServiceItem, Double> summa;
	public static volatile SingularAttribute<ServiceItem, Car> car;

}

