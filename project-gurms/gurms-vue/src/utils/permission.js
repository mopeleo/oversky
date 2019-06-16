'use strict';

/**
 * Button right define.
 * name: Recommended are capital letters with hyphens.
 * menuId: only numbers are allowed.
 * @type {{name: menuId}}
 */
const permission = {
    system: {
        user: {
            add: 101000001,
            access: 101000002,
            setRole: 101000003,
            edit: 101000004,
            freeze: 101000005,
            logout: 101000006,
            lock: 101000007,
            pwdReset: 101000008
        },
        role: {
            add: 102000001,
            edit: 102000002,
            del: 102000003,
            reset: 102000004,
            save: 102000005
        },
        org: {
          add: 103000001,
          edit: 103000002,
          del: 103000003
        },
        param: {
          save: 104000001
        },
        calendar: {
            init: 105000001,
            manage: 105000002
        }
    }
};

export default permission;
