package com.example.DeBiazi_Demo.Config;

import com.example.DeBiazi_Demo.Entity.Audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        Revision revision = (Revision) revisionEntity;
    }
}
