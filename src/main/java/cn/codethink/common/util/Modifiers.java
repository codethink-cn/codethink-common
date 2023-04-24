/*
 * Copyright 2023 CodeThink Technologies and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.codethink.common.util;

import com.google.common.base.Preconditions;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 修饰符
 *
 * @author Chuanwise
 */
@SuppressWarnings("unused")
public class Modifiers {
    private Modifiers() {
        Throwables.throwNoInstancesException(Modifiers.class);
    }
    
    /**
     * 判断成员是否是静态成员
     *
     * @param member 成员
     * @return 成员是否是静态成员
     */
    public static boolean isStatic(Member member) {
        Preconditions.checkNotNull(member, "Member is null!");
        
        final int modifiers = member.getModifiers();
        return Modifier.isStatic(modifiers);
    }
    
    /**
     * 判断方法是否是抽象方法
     *
     * @param method 方法
     * @return 方法是否是抽象成员
     */
    public static boolean isAbstract(Method method) {
        Preconditions.checkNotNull(method, "Method is null!");
        
        final int modifiers = method.getModifiers();
        return Modifier.isAbstract(modifiers);
    }
    
    /**
     * 判断成员是否是最终成员
     *
     * @param member 成员
     * @return 成员是否是最终成员
     */
    public static boolean isFinal(Member member) {
        Preconditions.checkNotNull(member, "Member is null!");
        
        final int modifiers = member.getModifiers();
        return Modifier.isFinal(modifiers);
    }
    
    /**
     * 判断成员是否是私有成员
     *
     * @param member 成员
     * @return 成员是否是私有成员
     */
    public static boolean isPrivate(Member member) {
        Preconditions.checkNotNull(member, "Member is null!");
        
        final int modifiers = member.getModifiers();
        return Modifier.isPrivate(modifiers);
    }
    
    /**
     * 判断成员是否是保护成员
     *
     * @param member 成员
     * @return 成员是否是保护成员
     */
    public static boolean isProtected(Member member) {
        Preconditions.checkNotNull(member, "Member is null!");
        
        final int modifiers = member.getModifiers();
        return Modifier.isProtected(modifiers);
    }
    
    /**
     * 判断成员是否是公共成员
     *
     * @param member 成员
     * @return 成员是否是公共成员
     */
    public static boolean isPublic(Member member) {
        Preconditions.checkNotNull(member, "Member is null!");
        
        final int modifiers = member.getModifiers();
        return Modifier.isPublic(modifiers);
    }
    
    /**
     * 判断成员是否是 volatile 成员
     *
     * @param member 成员
     * @return 成员是否是 volatile 成员
     */
    public static boolean isVolatile(Member member) {
        Preconditions.checkNotNull(member, "Member is null!");
        
        final int modifiers = member.getModifiers();
        return Modifier.isVolatile(modifiers);
    }
    
    /**
     * 判断成员是否是 strict 成员
     *
     * @param member 成员
     * @return 成员是否是 strict 成员
     */
    public static boolean isStrict(Member member) {
        Preconditions.checkNotNull(member, "Member is null!");
        
        final int modifiers = member.getModifiers();
        return Modifier.isStrict(modifiers);
    }
}