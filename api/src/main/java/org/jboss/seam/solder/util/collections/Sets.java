/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.seam.solder.util.collections;

import java.util.HashSet;
import java.util.Set;

public class Sets
{

   private Sets()
   {
   }

   /**
    * Calculates and returns the hash code of {@code s}.
    */
   static int hashCodeImpl(Set<?> s)
   {
      int hashCode = 0;
      for (Object o : s)
      {
         hashCode += o != null ? o.hashCode() : 0;
      }
      return hashCode;
   }

   /**
    * Creates an empty {@code HashSet} instance with enough capacity to hold the
    * specified number of elements without rehashing.
    * 
    * @param expectedSize the expected size
    * @return a new, empty {@code HashSet} with enough capacity to hold {@code
    *         expectedSize} elements without rehashing
    * @throws IllegalArgumentException if {@code expectedSize} is negative
    */
   public static <E> HashSet<E> newHashSetWithExpectedSize(int expectedSize)
   {
      return new HashSet<E>(Maps.capacity(expectedSize));
   }

}
