package fr.laCorp.utils;

import fr.laCorp.dtos.BasketDto;
import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.repositories.BasketDvdRepositoryModel;
import fr.laCorp.repositories.BasketRepositoryModel;
import fr.laCorp.services.BasketDvdServiceModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T12:58:33+0200",
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

    @Override
    public BasketDto basketServiceModelToBasketDto(BasketDvdServiceModel byId) {
        if ( byId == null ) {
            return null;
        }

        int id = 0;

        id = byId.getId();

        int idClient = 0;
        float totalPrice = 0.0f;

        BasketDto basketDto = new BasketDto( id, idClient, totalPrice );

        return basketDto;
    }

    @Override
    public BasketDvdServiceModel basketDvdDtoToBasketDvdServiceModel(BasketDvdDto basketDvdDto) {
        if ( basketDvdDto == null ) {
            return null;
        }

        BasketDvdServiceModel basketDvdServiceModel = new BasketDvdServiceModel();

        basketDvdServiceModel.setId( basketDvdDto.id() );
        basketDvdServiceModel.setIdBasket( basketDvdDto.idBasket() );
        basketDvdServiceModel.setIdDvd( basketDvdDto.idDvd() );
        basketDvdServiceModel.setQuantity( basketDvdDto.quantity() );
        basketDvdServiceModel.setPrice( basketDvdDto.price() );

        return basketDvdServiceModel;
    }

    @Override
    public BasketDvdRepositoryModel basketDvdServiceModelToBasketDvdRepositoryModel(BasketDvdServiceModel basketDvdServiceModel) {
        if ( basketDvdServiceModel == null ) {
            return null;
        }

        BasketDvdRepositoryModel basketDvdRepositoryModel = new BasketDvdRepositoryModel();

        basketDvdRepositoryModel.setId( basketDvdServiceModel.getId() );
        basketDvdRepositoryModel.setIdDvd( basketDvdServiceModel.getIdDvd() );
        basketDvdRepositoryModel.setQuantity( basketDvdServiceModel.getQuantity() );
        basketDvdRepositoryModel.setPrice( basketDvdServiceModel.getPrice() );

        return basketDvdRepositoryModel;
    }

    @Override
    public List<BasketDvdDto> listBasketDvdServiceModelToBasketDvdDto(List<BasketDvdServiceModel> basketDvdServiceModels) {
        if ( basketDvdServiceModels == null ) {
            return null;
        }

        List<BasketDvdDto> list = new ArrayList<BasketDvdDto>( basketDvdServiceModels.size() );
        for ( BasketDvdServiceModel basketDvdServiceModel : basketDvdServiceModels ) {
            list.add( basketDvdServiceModelToBasketDvdDto( basketDvdServiceModel ) );
        }

        return list;
    }

    @Override
    public List<BasketDvdServiceModel> iterableBasketDvdRepositoryModelToListBasketDvdServiceModel(Iterable<BasketDvdRepositoryModel> basketDvdRepositoryModelIterable) {
        if ( basketDvdRepositoryModelIterable == null ) {
            return null;
        }

        List<BasketDvdServiceModel> list = new ArrayList<BasketDvdServiceModel>();
        for ( BasketDvdRepositoryModel basketDvdRepositoryModel : basketDvdRepositoryModelIterable ) {
            list.add( basketDvdRepositoryModelToBasketDvdServiceModel( basketDvdRepositoryModel ) );
        }

        return list;
    }

    @Override
    public List<BasketRepositoryModel> iterableBasketRepositoryModelToListBasketDvdServiceModel(Iterable<BasketRepositoryModel> basketRepositoryModelIterable) {
        if ( basketRepositoryModelIterable == null ) {
            return null;
        }

        List<BasketRepositoryModel> list = new ArrayList<BasketRepositoryModel>();
        for ( BasketRepositoryModel basketRepositoryModel : basketRepositoryModelIterable ) {
            list.add( basketRepositoryModel );
        }

        return list;
    }

    @Override
    public List<BasketDvdServiceModel> iterableBasketRepositoryModelToListBasketServiceModel(Iterable<BasketRepositoryModel> basketRepositoryModelIterable) {
        if ( basketRepositoryModelIterable == null ) {
            return null;
        }

        List<BasketDvdServiceModel> list = new ArrayList<BasketDvdServiceModel>();
        for ( BasketRepositoryModel basketRepositoryModel : basketRepositoryModelIterable ) {
            list.add( basketRepositoryModelToBasketDvdServiceModel( basketRepositoryModel ) );
        }

        return list;
    }

    protected BasketDvdServiceModel basketRepositoryModelToBasketDvdServiceModel(BasketRepositoryModel basketRepositoryModel) {
        if ( basketRepositoryModel == null ) {
            return null;
        }

        BasketDvdServiceModel basketDvdServiceModel = new BasketDvdServiceModel();

        basketDvdServiceModel.setId( basketRepositoryModel.getId() );

        return basketDvdServiceModel;
    }
}
