package io.github.torikun9971.l2hostilityxups.capability;

public interface IDeathCounter {
    /**
     * Gets the current death count.
     *
     * @return The number of deaths
     */
    int getDeathCount();

    /**
     * Sets the new death count.
     *
     * @param count The new death count
     */
    void setDeathCount(int count);
}
