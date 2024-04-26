// Defined a method to deploy Grafana using Ansible
def call(Map configMap) {
    // Ensure required parameters are provided
    def ansiblePlaybook = configMap.playbook ?: '/var/lib/jenkins/workspace/Assignment6@libs/6782d7c5b1d4a18e916269bd48b3ba4ad093e46270fc0a85cd254410c77147dc/grafana/tests/test.yml'
    def inventory = configMap.inventory ?: '/var/lib/jenkins/workspace/Assignment6@libs/6782d7c5b1d4a18e916269bd48b3ba4ad093e46270fc0a85cd254410c77147dc/grafana/tests/inventory'
    def extraVars = configMap.extraVars ?: [:]

    // Validate playbook and inventory file paths
    if (!fileExists(ansiblePlaybook)) {
        echo "Error: Playbook file not found at ${ansiblePlaybook}"
        return
    }
    if (!fileExists(inventory)) {
        echo "Error: Inventory file not found at ${inventory}"
        return
    }

    // Execute Ansible playbook to deploy Grafana
    try {
        sh "ansible-playbook -i ${inventory} ${ansiblePlaybook} ${extraVars.collect { k, v -> "-e ${k}=${v}" }.join(' ')}"
    } catch (Exception e) {
        echo "Error executing Ansible playbook: ${e.message}"
        return
    }
}

def fileExists(String filePath) {
    return new File(filePath).exists()
}
