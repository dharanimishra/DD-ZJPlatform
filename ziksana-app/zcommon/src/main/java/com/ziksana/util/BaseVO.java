package com.ziksana.util;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * A base class for VO objects that implements a toString().
 *
 */
public class BaseVO
{
  @Override
  public final String toString()
  {
    return ToStringBuilder.reflectionToString(this);
  }
}
