package com.github.halo.recon.api;

/**
 * @author yzm
 * @date 2021/10/10 16:41
 */
public interface Copyable extends Cloneable {
    boolean isCopy();

    default Copyable clone() {
        return this.clone();
    }

}
