package com.antazri.climbingclub.business.contract;

import com.antazri.climbingclub.model.beans.Commentaire;

import java.util.List;

public interface ICommentaireByObjectBo<T, U> {

    U findByCommentaire(Commentaire pCommentaire);
    List<U> findByObject(T pObject);
    int addCommentaire(int pObjectId, int pCommentaireId);
    void deleteCommentaire(int pObjectId, int pCommentaireId);
}
