package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Commentaire;

import java.util.List;

public interface ICommentaireByObjectDao<T> {
    List<Commentaire> findByObject(T pObject);
    int addCommentaire(int pObjectId, int pCommentaireId);
    void deleteCommentaire(int pObjectId, int pCommentaireId);
}
