package fr.laCorp.utils;

import fr.laCorp.dtos.BasketDto;
import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.repositories.BasketDvdRepositoryModel;
import fr.laCorp.services.BasketDvdServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BasketMapper {
    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);

    BasketDvdServiceModel basketDvdRepositoryModelToBasketDvdServiceModel(BasketDvdRepositoryModel basketDvdRepositoryModel);

    BasketDvdDto basketDvdServiceModelToBasketDvdDto(BasketDvdServiceModel byId);

    BasketDto basketServiceModelToBasketDto(BasketDvdServiceModel byId);

    BasketDvdServiceModel basketDvdDtoToBasketDvdServiceModel(BasketDvdDto basketDvdDto);

    BasketDvdRepositoryModel basketDvdServiceModelToBasketDvdRepositoryModel(BasketDvdServiceModel basketDvdServiceModel);

    List<BasketDvdDto> listBasketDvdServiceModelToBasketDvdDto(List<BasketDvdServiceModel> basketDvdServiceModels);

    List<BasketDvdServiceModel> iterableBasketDvdRepositoryModelToListBasketDvdServiceModel(Iterable<BasketDvdRepositoryModel> basketDvdRepositoryModelIterable);
}
