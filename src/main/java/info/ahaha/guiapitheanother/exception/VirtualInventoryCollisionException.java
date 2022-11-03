package info.ahaha.guiapitheanother.exception;

import info.ahaha.guiapitheanother.VirtualInventory;

public class VirtualInventoryCollisionException extends VirtualInventoryException {
    public VirtualInventoryCollisionException(VirtualInventory inventory) {
        super(inventory);
    }
}
