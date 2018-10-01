package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Commentaire;

import java.util.List;

public interface ICommentaireByObjectDao<T, U> {

    U findByCommentaire(Commentaire pCommentaire);
    List<U> findByObject(T pObject);
    List<U> findAll();
    int addCommentaire(int pObjectId, int pCommentaireId);
    void deleteCommentaire(int pObjectId, int pCommentaireId);
}