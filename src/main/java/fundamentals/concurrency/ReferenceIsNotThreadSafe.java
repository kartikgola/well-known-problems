/*
 * Author: Kartik Gola
 * Date: 27/02/2021, 21:02
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
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
