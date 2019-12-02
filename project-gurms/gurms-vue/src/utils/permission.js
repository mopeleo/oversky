'use strict';

/**
 * Button right define.
 * name: Recommended are capital letters with hyphens.
 * menuId: only numbers are allowed.
 * @type {{name: menuId}}
 */
const permission = {
    system: {
        param: {
            edit: '1121',
            reset: '1122',
        },
        sno: {
            edit: '1131',
        },
        role: {
            detail: '1211',
            add: '1212',
            edit: '1213',
            delete: '1214',
        },
        user: {
            detail: '1221',
            add: '1222',
            edit: '1223',
            delete: '1224',
            grantrole: '1225',
            resetpassword: '1226',
            freeze: '1227',
            unfreeze: '1228',
        },
        org: {
            add: '1231',
            edit: '1232',
            delete: '1233',
        }
    },
    game: {
        custinfo: {
            freeze: '2112',
            unfreeze: '2113',
            resetpassword: '2114',
            add: '2115',
            edit: '2116',
            delete: '2117',
        },
        gameinfo: {
            add: '2212',
            edit: '2213',
            delete: '2214',
        },
        gamescene: {
            add: '2222',
            edit: '2223',
            delete: '2224',
        },
        gameactor: {
            add: '2232',
            edit: '2233',
            delete: '2234',
        },
        gameequip: {
            add: '2242',
            edit: '2243',
            delete: '2244',
        },
        gameitem: {
            add: '2252',
            edit: '2253',
            delete: '2254',
        }
    }

};

export default permission;
