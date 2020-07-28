package com.cpulover.ecommerce.config;

import com.cpulover.ecommerce.entity.Country;
import com.cpulover.ecommerce.entity.Product;
import com.cpulover.ecommerce.entity.ProductCategory;
import com.cpulover.ecommerce.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    //inject EntityManager by the constructor
    private EntityManager entityManager;

    @Autowired
    public DataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};
        Class[] classList = {Product.class, ProductCategory.class, Country.class, State.class};

        //disable HTTP methods for Product...: PUT, POST and DELETE
        disableMethods(config, theUnsupportedActions, classList);

        //call an internal helper method
        exposeIds(config);
    }

    private void disableMethods(RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions, Class[] classList) {
        for (Class theClass : classList) {
            config.getExposureConfiguration()
                    .forDomainType(theClass)
                    .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                    .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
        }
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        //get a list of all Entities
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //create array of the Entity types
        List<Class> entityClasses = new ArrayList<>();

        //get the list of all Entity types
        for (EntityType entity : entities) {
            entityClasses.add(entity.getJavaType());
        }

        //convert list to array of Class, provide an instance of an array (new Class[0])
        Class[] domainTypes = entityClasses.toArray(new Class[0]);

        //expose the entity types in the array
        config.exposeIdsFor(domainTypes);
    }

}

