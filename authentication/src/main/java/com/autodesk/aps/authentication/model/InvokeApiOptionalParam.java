package com.autodesk.aps.authentication.model;

public class InvokeApiOptionalParam {
/**
 * Represents optional parameters for the `fetchToken` method.
 * This class uses the Builder pattern to allow flexible construction of
 * objects.
 */

    private boolean userInfo;
   ;

    private InvokeApiOptionalParam(Builder builder) {
        this.userInfo = builder.userInfo;
    }

    /**
     * Builder class for constructing instances of InvokeApiOptionalParam.
     */
    public static class Builder {
        private boolean userInfo;

        public Builder userInfo(boolean userInfo) {
            this.userInfo = userInfo;
            return this;
        }

        /**
         * Builds and returns an instance of InvokeApiOptionalParam.
         * 
         * @return InvokeApiOptionalParam object.
         */
        public InvokeApiOptionalParam build() {
            return new InvokeApiOptionalParam(this);
        }
    }

    /**
     * Gets the userInfo value.
     *
     * @return boolean
     */
    public boolean isUserInfo() {
        return userInfo;
    }

}
