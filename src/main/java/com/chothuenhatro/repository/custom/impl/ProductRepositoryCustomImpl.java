package com.chothuenhatro.repository.custom.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.chothuenhatro.builder.ProductSearchBuilder;
import com.chothuenhatro.entity.ProductEntity;
import com.chothuenhatro.entity.UserEntity;
import com.chothuenhatro.repository.custom.ProductRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductEntity> findByCondition(ProductSearchBuilder productSearchBuilder) {
        try {
            StringBuilder sb = new StringBuilder("select * from product p where 1 = 1");
            sb = buildQuerySearch(productSearchBuilder, sb);
            Query query = entityManager.createNativeQuery(sb.toString(), ProductEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProductEntity> findProductByUser(UserEntity userEntity) {
        try {
            StringBuilder sb = new StringBuilder("");
            sb.append("select * from product where modifiedby like '%" + userEntity.getUserName() + "%'");
            Query query = entityManager.createNativeQuery(sb.toString(), ProductEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private StringBuilder buildQuerySearch(ProductSearchBuilder productSearchBuilder, StringBuilder sb) {
        if (StringUtils.isNotBlank(productSearchBuilder.getProductCategory())) {
            sb.append(" and exists (" +
                    "select * from productcategory as pc " +
                    "where pc.id = p.productcategoryid and pc.code like '%" + productSearchBuilder.getProductCategory() + "%')");
        }
        if (StringUtils.isNotBlank(productSearchBuilder.getArea())) {
            sb = buildQueryForArea(sb, productSearchBuilder.getArea());
        }
        if (StringUtils.isNotBlank(productSearchBuilder.getDistrict())) {
            sb.append(" and p.district like '%" + "" + productSearchBuilder.getDistrict() + "%'");
        }
        if (StringUtils.isNotBlank(productSearchBuilder.getPrice())) {
            sb = buildQueryForPrice(sb, productSearchBuilder.getPrice());
        }
        return sb;
    }

    private StringBuilder buildQueryForPrice(StringBuilder sb, String priceValue) {
        switch (priceValue) {
            case "P1":
            {
                sb.append(" and p.price <= 1");
            }
                break;
            case "P2":
            {
                sb.append(" and p.price >= 1 and p.price <= 2");
            }
                break;
            case "P3":
            {
                sb.append(" and p.price >= 2 and p.price <= 3");
            }
                break;
            case "P5":
            {
                sb.append(" and p.price >= 3 and p.price <= 5");
            }
                break;
            case "P7":
            {
                sb.append(" and p.price >= 5 and p.price <= 7");
            }
                break;
            case "P10":
            {
                sb.append(" and p.price >= 7 and p.price <= 10");
            }
                break;
            case "POTHERS":
            {
                sb.append(" and p.price >= 10");
            }
                break;
            default:
                break;
        }
        return sb;
    }

    private StringBuilder buildQueryForArea(StringBuilder sb, String areaValue) {
        switch (areaValue) {
            case "A30":
            {
                sb.append(" and p.area <= 30");
            }
                break;
            case "A50":
            {
                sb.append(" and p.area >= 30 and p.area <= 50");
            }
                break;
            case "A70":
            {
                sb.append(" and p.area >= 50 and p.area <= 70");
            }
                break;
            case "A100":
            {
                sb.append(" and p.area >= 70 and p.area <= 100");
            }
                break;
            case "AOTHERS":
            {
                sb.append(" and p.area >= 100");
            }
                break;
            default:
                break;
        }

        return sb;
    }
}
