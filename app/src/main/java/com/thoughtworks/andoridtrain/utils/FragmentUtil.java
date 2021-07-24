package com.thoughtworks.andoridtrain.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.thoughtworks.andoridtrain.R;

public class FragmentUtil {

    public static void replaceFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment,int fragmentId,@Nullable String tag){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(fragmentId,fragment,tag);
        transaction.addToBackStack(tag);
        transaction.commitAllowingStateLoss();
    }
}
