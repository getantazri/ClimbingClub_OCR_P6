package com.antazri.climbingclub.consumer.contract;

import java.util.List;

public interface ICommentaireByObjectDao<T, U> {
    List<U> findByObject(T pObject);
    int addCommentaire(int pObjectId, int pCommentaireId);
    void deleteCommentaire(int pObjectId, int pCommentaireId);
}