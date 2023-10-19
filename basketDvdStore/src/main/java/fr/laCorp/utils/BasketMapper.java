package fr.laCorp.utils;

import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.repositories.BasketDvdRepositoryModel;
import fr.laCorp.services.BasketDvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BasketMapper {
    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);

    BasketDvdServiceModel basketDvdRepositoryModelToBasketDvdServiceModel(BasketDvdRepositoryModel basketDvdRepositoryModel);

    BasketDvdDto basketDvdServiceModelToBasketDvdDto(BasketDvdServiceModel byId);
}
