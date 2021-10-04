/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.concurrency;

public class ReferenceIsNotThreadSafe {

    // This reference is not thread safe!
    private ImmutableInteger currentValue = null;

    public ImmutableInteger getValue(){
        return currentValue;
    }

    // Reference
    public void setValue(ImmutableInteger newValue){
        this.currentValue = newValue;
    }

    public void add(int newValue){
        this.currentValue = this.currentValue.add(newValue);
    }
}
