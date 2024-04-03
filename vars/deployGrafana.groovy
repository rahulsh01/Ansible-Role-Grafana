// Defined a method to deploy Grafana using Ansible
def call(Map configMap) {
    // Ensure required parameters are provided
    def ansiblePlaybook = configMap.playbook ?: '/home/ubuntu/Ansible-Role-Grafana/grafana/tasks/main.yml'
    def inventory = configMap.inventory ?: '/home/ubuntu/Ansible-Role-Grafana/grafana/tests/inventory'
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
