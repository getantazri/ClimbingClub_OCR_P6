package com.antazri.climbingclub.business.contract;

import java.util.List;

public interface ICommentaireByObjectBo<T, U> {

    List<U> findByObject(T pObject);
    int addCommentaire(int pObjectId, int pCommentaireId);
    void deleteCommentaire(int pObjectId, int pCommentaireId);
}
