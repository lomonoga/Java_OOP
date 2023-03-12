package education.factories;

import education.interfaces.IAdmittance;

/***
 * Main Factory of Admittance
 */
public abstract class AdmittanceFactory {
    public abstract IAdmittance createAdmittance(double point) throws Exception;
}
