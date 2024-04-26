Grafana
=========

The Grafana role automates the installation and configuration of Grafana, an open-source analytics and monitoring platform. It ensures Grafana is installed on CentOS (Red Hat) or Ubuntu (Debian) systems, configuring it with customizable settings.

Requirements
------------

Internet access for package downloads.

Supported OS: CentOS (Red Hat) or Ubuntu (Debian).

Basic system utilities and Python installed.

Role Variables
--------------
grafana_version: Specify the version of Grafana to install.

grafana_config_path: Path to the Grafana configuration file.

grafana_service_name: Name of the Grafana service.

Additional variables can be added for customization as needed.

Dependencies
------------

Ansible for playbook execution.

Package manager for installing Grafana.

Python for Ansible execution and system utilities

## Example Playbook:

- hosts: localhost
  
  vars:
  
    grafana_version: "8.0.0"
  
    grafana_config_path: "/etc/grafana/grafana.ini"
  
    grafana_service_name: "grafana-server"
  
  roles:
  
    - grafana


![grafana-logo](https://github.com/OT-MyGurukulam/Ansible_Batch_25/assets/160396963/f27a69c9-68e4-46fe-a6f8-53921254d327)
