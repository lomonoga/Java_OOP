package education.factories;

import education.Mark;
import education.interfaces.IAdmittance;

/**
 * Factory of Mark
 */
public class MarkFactory extends AdmittanceFactory {
    @Override
    public IAdmittance createAdmittance(double point) throws Exception{
        return new Mark(point);
    }
}
