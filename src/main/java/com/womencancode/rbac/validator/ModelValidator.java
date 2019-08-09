package com.womencancode.rbac.validator;

import com.womencancode.rbac.exception.EntityNotFoundException;
import com.womencancode.rbac.exception.InvalidFieldException;
import com.womencancode.rbac.exception.ServiceException;
import com.womencancode.rbac.model.BaseModel;
import lombok.Getter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.StringUtils;

import java.util.List;

@Getter
public abstract class ModelValidator<T extends BaseModel> {

    private CrudRepository repository;

    public ModelValidator(CrudRepository repository) {
        this.repository = repository;
    }

    /**
     * Apply validations for a bulk insert.
     *
     * @param models
     * @throws ServiceException
     */
    public void validateInsert(List<T> models) throws ServiceException {
        for (T model : models) {
            validateInsert(model);
        }
    }


    /**
     * Additional validation to be executed in the insert validation
     *
     * @param model
     */
    public abstract void customInsertValidation(T model) throws ServiceException;

    /**
     * Validates a model based on conditions that must comply before inserting a model into database
     *
     * @param model
     * @throws ServiceException
     */
    public void validateInsert(T model) throws ServiceException {
        if (StringUtils.hasLength(model.getId()))
            throw new InvalidFieldException("Id is an invalid parameter for the insert action");

        customInsertValidation(model);
    }

    /**
     * Validates a model id based on conditions that must comply before inserting a model into database
     *
     * @param id
     * @throws EntityNotFoundException
     */
    public void validateId(String id) throws EntityNotFoundException {
        String className = getClass().getName();
        if (!repository.findById(id).isPresent())
            throw new EntityNotFoundException(String.format("%s %s not found", className, id));
    }
}
