
import hudson.model.*
import jenkins.model.*

def call(String jobPath, ArrayList parameters) {
    def job = Jenkins.instance.getItemByFullName(jobPath, Job.class)
    def jobParams = new ParametersAction(parameters.collect { new StringParameterValue(it.key, it.value)})
    def build = job.scheduleBuild2(0, jobParams)
    return build
}
