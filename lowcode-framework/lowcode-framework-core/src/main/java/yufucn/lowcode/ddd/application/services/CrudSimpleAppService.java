package yufucn.lowcode.ddd.application.services;

import lombok.Getter;
import lombok.Setter;
import yufucn.lowcode.ddd.application.contracts.dtos.PagedAndSortedResultRequestDto;
import yufucn.lowcode.ddd.application.convert.ISimpleMapper;
import yufucn.lowcode.ddd.domain.entities.AbstractBaseEntityKey;
import yufucn.lowcode.ddd.domain.repositories.IRepository;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 * @date 2023/1/1 15:24
 */
@MappedSuperclass
public abstract class CrudSimpleAppService<
        TKey extends Serializable,
        TEntity extends AbstractBaseEntityKey<TKey>,
        TEntityDto>
        extends CrudDetailCreateSingleAppService<
        TKey,
        TEntity,
        TEntityDto,
        PagedAndSortedResultRequestDto> {
    private ISimpleMapper<TEntity, TEntityDto> mapper;

    public CrudSimpleAppService(IRepository<TEntity, TKey> repository,
                                ISimpleMapper<TEntity, TEntityDto> mapper) {
        super(repository, mapper);
    }
}
