/*
 * File:                GeneralizedScalarRadialBasisKernel.java
 * Authors:             Dan Morrow
 * Company:             Sandia National Laboratories
 * Project:             Cognitive Foundry
 *
 * Copyright August 31, 2009, Sandia Corporation.
 * Under the terms of Contract DE-AC04-94AL85000, there is a non-exclusive
 * license for use of this work by or on behalf of the U.S. Government. Export
 * of this program may require a license from the United States Government.
 * See CopyrightHistory.txt for complete details.
 *
 */

package gov.sandia.cognition.learning.function.kernel;
import gov.sandia.cognition.util.AbstractCloneableSerializable;


// TODO: I don't like the name of this class. -- jdbasil (2009-08-31)

/**
 *implements a scalar kernel function of the form:
 * dist is the absolute difference between the two scalar inputs
 * k = exp( -constant * dist^exponent )
 *
 * @author jdmorr
 */
public class GeneralizedScalarRadialBasisKernel
        extends AbstractCloneableSerializable
        implements Kernel<Double>
{
    public static final double DEFAULT_EXPONENT = 1.0;
    public static final double DEFAULT_CONSTANT = 1.0;
    protected double exponent ;
    protected double constant;



    public GeneralizedScalarRadialBasisKernel()
    {
       this(DEFAULT_CONSTANT, DEFAULT_EXPONENT);
    }

    public double evaluate( Double x, Double y )
    {
        double result = 0.0;

        double dist = Math.abs(x-y);

        result = Math.exp( -constant * Math.pow(dist, exponent));

        return result;
    }

    /**
     * 
     * @param exponent
     * @param constant
     */
    public GeneralizedScalarRadialBasisKernel( final double exponent, final double constant )
    {
        super();
        
        this.setConstant(constant);
        this.setExponent(exponent);
    }

    /**
     * @return the exponent
     */
    public double getExponent()
    {
        return exponent;
    }

    /**
     * @param exponent the exponent to set
     */
    public void setExponent(double exponent)
    {
        this.exponent = exponent;
    }

    /**
     * @return the constant
     */
    public double getConstant()
    {
        return constant;
    }

    /**
     * @param constant the constant to set
     */
    public void setConstant(double constant)
    {
        if ( constant <= 0 )
        {
            throw new IllegalArgumentException("constant must be positive!");
        }
        this.constant = constant;
    }

    

}
