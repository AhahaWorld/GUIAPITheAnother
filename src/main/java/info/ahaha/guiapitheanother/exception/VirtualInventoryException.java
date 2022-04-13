package info.ahaha.guiapitheanother.exception;

import info.ahaha.guiapitheanother.VirtualInventory;

public class VirtualInventoryException extends Exception{
    public VirtualInventoryException(VirtualInventory virtualInventory) {
        this.virtualInventory = virtualInventory;
    }

    public VirtualInventoryException(String message, VirtualInventory virtualInventory) {
        super(message);
        this.virtualInventory = virtualInventory;
    }

    public VirtualInventoryException(String message, Throwable cause, VirtualInventory virtualInventory) {
        super(message, cause);
        this.virtualInventory = virtualInventory;
    }

    public VirtualInventoryException(Throwable cause, VirtualInventory virtualInventory) {
        super(cause);
        this.virtualInventory = virtualInventory;
    }

    protected VirtualInventory virtualInventory;

    public VirtualInventory getVirtualInventory() {
        return virtualInventory;
    }
}
