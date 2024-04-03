// Defined a method to deploy Grafana using Ansible
def call(Map configMap) {
    // Ensuring required parameters are provided
    def ansiblePlaybook = configMap.playbook ?: '/home/ubuntu/Ansible-Role-Grafana/grafana/tasks/main.yml'
    def inventory = configMap.inventory ?: '/home/ubuntu/Ansible-Role-Grafana/grafana/tests/inventory'
    def extraVars = configMap.extraVars ?: [:]

    // Execute Ansible playbook to deploy Grafana
    sh "ansible-playbook -i ${inventory} ${ansiblePlaybook} ${extraVars.collect { k, v -> "-e ${k}=${v}" }.join(' ')}"
}

