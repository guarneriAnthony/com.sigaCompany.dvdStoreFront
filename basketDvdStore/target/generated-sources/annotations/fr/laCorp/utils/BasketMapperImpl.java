package fr.laCorp.utils;

import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.repositories.BasketDvdRepositoryModel;
import fr.laCorp.services.BasketDvdServiceModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T12:48:17+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
public class BasketMapperImpl implements BasketMapper {

    @Override
    public BasketDvdServiceModel basketDvdRepositoryModelToBasketDvdServiceModel(BasketDvdRepositoryModel basketDvdRepositoryModel) {
        if ( basketDvdRepositoryModel == null ) {
            return null;
        }

        BasketDvdServiceModel basketDvdServiceModel = new BasketDvdServiceModel();

        basketDvdServiceModel.setId( basketDvdRepositoryModel.getId() );
        basketDvdServiceModel.setIdBasket( basketDvdRepositoryModel.getIdBasket() );
        basketDvdServiceModel.setIdDvd( basketDvdRepositoryModel.getIdDvd() );
        basketDvdServiceModel.setQuantity( basketDvdRepositoryModel.getQuantity() );
        basketDvdServiceModel.setPrice( basketDvdRepositoryModel.getPrice() );

        return basketDvdServiceModel;
    }

    @Override
    public BasketDvdDto basketDvdServiceModelToBasketDvdDto(BasketDvdServiceModel byId) {
        if ( byId == null ) {
            return null;
        }

        int id = 0;
        int idBasket = 0;
        int idDvd = 0;
        int quantity = 0;
        float price = 0.0f;

        id = byId.getId();
        idBasket = byId.getIdBasket();
        idDvd = byId.getIdDvd();
        quantity = byId.getQuantity();
        price = byId.getPrice();

        BasketDvdDto basketDvdDto = new BasketDvdDto( id, idBasket, idDvd, quantity, price );

        return basketDvdDto;
    }
}
