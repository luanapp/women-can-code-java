package com.womencancode.rbac.validator;

import com.womencancode.rbac.model.Role;
import com.womencancode.rbac.model.User;
import com.womencancode.rbac.repository.RoleRepository;
import com.womencancode.rbac.repository.UserRepository;
import com.womencancode.rbac.model.BaseModel;
import org.springframework.data.repository.CrudRepository;

public class ValidatorFactory {
    public static <T extends BaseModel> ModelValidator getValidator(Class<T> clazz, CrudRepository repository) {
        if (User.class.equals(clazz))
            return new UserValidator((UserRepository) repository);

        if (Role.class.equals(clazz))
            return new RoleValidator((RoleRepository) repository);

        return null;
    }
}
