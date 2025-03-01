package com.prueba.ms_identity.domain.api;

import java.util.List;

public interface IGenericServicePort<T,ID> {

    void saveModel(T model);

    List<T> getAllModel();

    T getModel(ID id);

    void updateModel(T model);

    void deleteModel(ID id);

}
