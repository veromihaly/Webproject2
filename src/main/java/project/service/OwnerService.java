package project.service;

import java.util.List;

import project.uito.OwnerUITO;

public interface OwnerService {
    OwnerUITO doSaveOwner(OwnerUITO ownerUiTO);

    List<OwnerUITO> doFetchAllOwner();

    OwnerUITO doGetOwner(OwnerUITO ownerUiTO);

    void doDeleteOwner(OwnerUITO ownerUiTO);
}
