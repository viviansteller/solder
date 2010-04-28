/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.extensions.genericbean;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.InjectionTarget;

/**
 * injection target wrapper used for beans that have generic producer fields
 * 
 * @author Stuart Douglas <stuart@baileyroberts.com.au>
 * 
 * @param <T>
 */
public class ProducerFieldInjectionTarget<T> implements InjectionTarget<T>
{
   private final InjectionTarget<T> delegate;
   private final List<FieldSetter> fieldSetters;

   public ProducerFieldInjectionTarget(InjectionTarget<T> delegate, List<FieldSetter> fieldSetters)
   {
      this.delegate = delegate;
      this.fieldSetters = fieldSetters;
   }

   public void inject(T instance, CreationalContext<T> ctx)
   {
      for (FieldSetter f : fieldSetters)
      {
         f.set(instance, ctx);
      }
      delegate.inject(instance, ctx);
   }

   public void postConstruct(T instance)
   {
      delegate.postConstruct(instance);
   }

   public void preDestroy(T instance)
   {
      delegate.preDestroy(instance);
   }

   public void dispose(T instance)
   {
      delegate.dispose(instance);
   }

   public Set<InjectionPoint> getInjectionPoints()
   {
      return delegate.getInjectionPoints();
   }

   public T produce(CreationalContext<T> ctx)
   {
      return delegate.produce(ctx);
   }

}