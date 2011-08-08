/*
 * File:                ConfidenceIntervalEvaluator.java
 * Authors:             Kevin R. Dixon
 * Company:             Sandia National Laboratories
 * Project:             Cognitive Foundry
 *
 * Copyright August 16, 2007, Sandia Corporation.  Under the terms of Contract
 * DE-AC04-94AL85000, there is a non-exclusive license for use of this work by
 * or on behalf of the U.S. Government. Export of this program may require a
 * license from the United States Government. See CopyrightHistory.txt for
 * complete details.
 *
 */

package gov.sandia.cognition.statistics.method;

/**
 * Computes a confidence interval for a given dataset and confidence (power)
 * level
 *
 * @param   <DataType> The type of data to compute the confidence interval over.
 * @author Kevin R. Dixon
 * @since  2.0
 */
public interface ConfidenceIntervalEvaluator<DataType>
{
    
    /**
     * Computes a confidence interval for a given dataset and confidence (power)
     * level
     * 
     * @param data 
     * Dataset to use to compute the ConfidenceInterval
     * @param confidence 
     * Confidence level (power, 1-pvalue) for the ConfidenceInterval,
     * must be on the interval (0,1]
     * @return 
     * ConfidenceInterval describing the range of values that contain the
     * estimate for the given confidence level
     */
    ConfidenceInterval computeConfidenceInterval(
        DataType data,
        double confidence );

    /**
     * Computes the confidence interval given the mean and variance of
     * the samples, number of samples, and corresponding confidence interval
     * @param mean
     * Mean of the distribution.
     * @param variance
     * Variance of the distribution.
     * @param numSamples
     * Number of samples in the underlying data
     * @param confidence
     * Confidence value to assume for the ConfidenceInterval
     * @return
     * ConfidenceInterval capturing the range of the mean of the data
     * at the desired level of confidence
     */
    ConfidenceInterval computeConfidenceInterval(
        double mean,
        double variance,
        int numSamples,
        double confidence );
    
}
