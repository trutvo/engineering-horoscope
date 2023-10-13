package com.github.engineeringhoroscope.oldjavaapi.adapter;

import com.github.engineeringhoroscope.bl.ports.OldApi;

class OldJavaApi implements OldApi {
    public boolean isTrue(Object obj) {
        return Boolean.valueOf(String.valueOf(obj));
    }
}